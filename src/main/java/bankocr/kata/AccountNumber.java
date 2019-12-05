package bankocr.kata;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountNumber {

    private static final int CODE_LENGTH = 9;
    private static final String ERROR_MARKER = "ERR";

    private Entry entry;

    public AccountNumber(Entry entry) {
        this.entry = entry;
    }

    private boolean validCode(String code)
    {
        ArrayList<Integer> numbers = code.codePoints()
                .mapToObj(c -> Character.getNumericValue(c)).collect(Collectors.toCollection(ArrayList::new));

        int sum = 0;
        for(int i=0;i<code.length();i++)
        {
            sum+=(i+1)*numbers.get(i);
        }
        return sum%11==0;
    }

    @Override
    public String toString()
    {
        String code = entry.toString();
        if(validCode(code))
            return code;
        return code + " " + ERROR_MARKER;

    }
}
