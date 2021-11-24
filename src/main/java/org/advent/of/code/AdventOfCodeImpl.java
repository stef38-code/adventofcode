package org.advent.of.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdventOfCodeImpl extends HttpTools implements AdventOfCode{
    private final String year;
    private final String day;

    public void getSource(){
        String content = getFileContent(year, day);
    }
    /*public static void main(String[] args) {
        AdventOfCode adventOfCode = new AdventOfCode();
        adventOfCode.test();
    }*/

}
