package com.acolyte.managerapp.filework;

import com.acolyte.managerapp.member.Member;
import com.acolyte.managerapp.member.MultiClubMember;
import com.acolyte.managerapp.member.SingleClubMember;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileHandler {

    public List<Member> readFile() {
        List<Member> members = new LinkedList<>();
        String lineRead;
        String[] splitLine;
        Member member;

        try(BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            lineRead = reader.readLine();

            while (lineRead != null) {
                splitLine = lineRead.split(", ");
                if (splitLine[0].equals('S')) {
                    member = new SingleClubMember('S',
                            Integer.parseInt(splitLine[1]),
                            splitLine[2],
                            Double.parseDouble(splitLine[3]),
                            Integer.parseInt(splitLine[4]));
                } else {
                    member = new MultiClubMember('M',
                            Integer.parseInt(splitLine[1]),
                            splitLine[2],
                            Double.parseDouble(splitLine[3]),
                            Integer.parseInt(splitLine[4]));
                }
                members.add(member);
                lineRead = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return members;
    }

    public void appendFile(String member) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true))) {
            writer.write(member + System.lineSeparator());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
