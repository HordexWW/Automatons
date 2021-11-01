package com.sshmygin.detfinautomaton.filereader.nondeterministic;

import com.sshmygin.detfinautomaton.filereader.deterministic.RawDFSAData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NFAPropertyReader {
    public RawNFSAData getAutomatonProperties(String filename) {
        RawNFSAData data = new RawNFSAData();
        try (BufferedReader fis = new BufferedReader(new FileReader(filename))) {
            data.setNumOfStates(Integer.parseInt(fis.readLine()));
            data.setAlphabet(Arrays.stream(fis.readLine().split(" ")).toList());

            List<List<List<Integer>>> transitionTableData = new ArrayList<>();


            for (int i = 0; i < data.getNumOfStates(); i++) {
                List<List<Integer>> row = new ArrayList<>();
                List<String> rawCells = Arrays.stream(fis.readLine().split(";")).toList();
                for (String cell: rawCells) {
                    List<String> listOfStates = Arrays.stream(cell.split(" ")).toList();
                    List<Integer> integerList = listOfStates.stream().map(Integer::parseInt).toList();
                    row.add(integerList);
                }
                transitionTableData.add(row);
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
