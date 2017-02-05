package org.manyu.klefimclosed;

import org.apache.commons.cli.*;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AlgoKLEFIMClosed obj =new AlgoKLEFIMClosed();
        CommandLine commandLine;
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();
        options.addOption("i", true, "get input file");
        options.addOption("o", true, "get output file");
        options.addOption("k", true, "get K");
        options.addOption("tm", true, "set transaction merging");
        options.addOption("c", true, "get transaction count");
        options.addOption("cp", true, "activate closed pattern jump");
        options.addOption("sup", true, "set subtree utility pruning");
        options.addOption("minlen", true, "minimum length of itemset");
        options.addOption("maxlen", true, "maximum length of it0.emset");
        int k=100;
        String inputPath="mushroom.txt";
        String outputPath="abc.txt";
        boolean activateTransactionMerging=true;
        int maximumTransactionCount=8124;
        boolean activateSubtreeUtilityPruning=true;
        int minLen=0;
        int maxLen=100;
        boolean activateClosedPatternJump=false;
        try {
            commandLine=parser.parse(options,args);
            k=Integer.parseInt(commandLine.getOptionValue("k"));
            inputPath=commandLine.getOptionValue("i");
            outputPath=commandLine.getOptionValue("o");
            maximumTransactionCount=Integer.parseInt(commandLine.getOptionValue("c"));
            activateSubtreeUtilityPruning=Boolean.parseBoolean(commandLine.getOptionValue("sup"));
            activateTransactionMerging=Boolean.parseBoolean(commandLine.getOptionValue("tm"));
            activateClosedPatternJump=Boolean.parseBoolean(commandLine.getOptionValue("cp"));
            minLen=Integer.parseInt(commandLine.getOptionValue("minlen"));
            maxLen=Integer.parseInt(commandLine.getOptionValue("maxlen"));
            obj.runAlgorithm(k,1,inputPath,outputPath,activateTransactionMerging,maximumTransactionCount,activateSubtreeUtilityPruning,activateClosedPatternJump,minLen,maxLen);
            obj.printStats();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
