package com.sshmygin.detfinautomaton.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TXTPropertyReader {
    public Data getAutomatonProperties(String filename) {
        Data data = new Data();
        try (BufferedReader fis = new BufferedReader(new FileReader(filename))) {
            data.setNumOfStates(Integer.parseInt(fis.readLine()));
            data.setAlphabet(Arrays.stream(fis.readLine().split(" ")).toList());

            List<List<Integer>> transitionTableData = new ArrayList<>();

            for (int i = 0; i < data.getNumOfStates(); i++) {
                List<String> stringList = Arrays.stream(fis.readLine().split(" ")).toList();
                List<Integer> integerList = stringList.stream().map(Integer::parseInt).toList();
                transitionTableData.add(integerList);
            }
            data.setTransitionTable(transitionTableData);
            data.setBeginningState(Integer.parseInt(fis.readLine()));
            data.setEndingStateSet(Arrays.stream(fis.readLine().split(" ")).toList()
                    .stream().map(Integer::parseInt).toList());

        } catch (IOException e) {
            System.out.println("Couldn't read data");
            return data;
        }
        return data;
    }
}
