package com.sshmygin.automatons;

import com.sshmygin.automatons.automaton.FiniteStateAutomaton;
import com.sshmygin.automatons.automaton.nondeterministic.NFSAData;
import com.sshmygin.automatons.automaton.nondeterministic.NondeterministicFiniteStateAutomaton;
import com.sshmygin.automatons.filereader.nondeterministic.NFAPropertyReader;
import com.sshmygin.automatons.filereader.nondeterministic.RawNFSAData;
import com.sshmygin.automatons.handler.AutomatonDataHandler;

public class MainNFA {
    public static void main(String[] args) {
//        String filePath = "/Users/sshmygin/Documents/projects/SSU/DetFinAutomate/src/main/resources/NFAinput.txt";
        String filePath = "/Users/sshmygin/IdeaProjects/Automatons/src/main/resources/NFA/NFAInput2.txt";

        NFAPropertyReader reader = new NFAPropertyReader();
        RawNFSAData rawData = reader.getAutomatonProperties(filePath);

        AutomatonDataHandler dataHandler = new AutomatonDataHandler();
        NFSAData nfsaData = dataHandler.getNFSAData(rawData);

        System.out.println(nfsaData);

        FiniteStateAutomaton automaton = new NondeterministicFiniteStateAutomaton(nfsaData);

        String word = "abbbb";

        System.out.println(automaton.wordAcceptable(word));

    }
}
