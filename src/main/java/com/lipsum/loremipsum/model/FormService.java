package com.lipsum.loremipsum.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FormService {
    final String LIPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in tempor nulla. Curabitur placerat posuere tellus, a maximus nunc pharetra non. Donec a luctus velit, sit amet tincidunt sem. Curabitur tincidunt nisi a libero dignissim, vitae tempus orci consectetur. Etiam fermentum, nisi fermentum ullamcorper tincidunt, arcu neque viverra felis, nec interdum quam augue ut nunc. Morbi condimentum ut dui sit amet tempor. Sed fermentum sit amet orci quis molestie. Etiam pharetra condimentum odio ac dignissim. Donec sed ultricies dui. Proin suscipit urna nec orci accumsan tempus. Praesent bibendum nec tortor nec pharetra. Donec suscipit viverra libero, varius malesuada massa maximus iaculis. Suspendisse ac scelerisque elit, in vehicula lacus. Morbi at ullamcorper mauris. Morbi ultricies diam aliquam, tempor magna sit amet, tristique ligula.In id accumsan urna. Ut varius condimentum ipsum. Duis fringilla ornare ipsum, sodales semper arcu egestas a. Proin ornare magna in nisl imperdiet lobortis. Vivamus magna massa, vehicula eu tellus a, tempus accumsan mauris. Proin porttitor finibus sem, sed iaculis purus lacinia at. Donec ornare nulla sapien, sit amet cursus orci pulvinar a. Nam et fermentum lacus. In laoreet leo eget velit blandit luctus. Phasellus eu sem vestibulum, mattis massa quis, ornare sapien. Proin non mattis nulla. Vestibulum venenatis erat sit amet metus venenatis tincidunt. Aenean pharetra, dui sit amet condimentum blandit, velit orci posuere velit, sed tristique urna mi sit amet dolor. In et dui quis metus scelerisque dapibus faucibus in quam. Aenean mattis nisi vel risus condimentum aliquam. Nunc consequat lorem ut sodales lacinia. Nam at nunc in magna mattis suscipit. Integer condimentum ullamcorper lobortis. Sed tincidunt purus ut urna ultrices, vel elementum mi scelerisque. Phasellus feugiat efficitur erat eget condimentum. Suspendisse ac lacinia turpis. Proin pellentesque lacus ac porttitor mattis. Integer tincidunt egestas rutrum. Praesent quis lectus elit. Pellentesque imperdiet, est vitae posuere volutpat, mauris lacus tincidunt leo, in dignissim turpis tortor ac sapien. Aenean accumsan condimentum purus, ac ultricies libero aliquam porta. Donec molestie, ante et sagittis dignissim, libero enim luctus turpis, sit amet varius diam dui vel turpis. Donec ultricies nibh eget lacinia lacinia. Aenean et urna a nunc euismod facilisis non dapibus ex. Proin porta ex quis tincidunt tincidunt. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec feugiat odio id erat placerat, non varius ligula tempor. Nulla non aliquam mauris. Nam congue rutrum ornare. Suspendisse potenti. Nam consequat ullamcorper nibh, sit amet ornare enim placerat nec. Nunc sapien mi, egestas sed sapien quis, luctus euismod augue. Proin accumsan nulla vitae purus dignissim dictum. Nunc vehicula porta porttitor. Sed mattis varius ultricies.";
    private String lipsum;
    private int number;
    private String type;

    public String generateList(int num) {
        String[] lipsum = LIPSUM.split("\\.");
        String[] arrayResult = new String[num];
        String tmpTxt = "";

        int currentListNumber = 0;
        while (currentListNumber < num) {
            for (String s : lipsum) {
                tmpTxt += "\t<li>" + s + "</li>\n";
                currentListNumber++;
                if (currentListNumber == num) {
                    break;
                }
            }
        }
        return "<ul>\n" + tmpTxt + "</ul>";
    }

    public String generateWords(int num) {
        String[] lipsum = LIPSUM.split("\\s+");
        String[] arrayResult = new String[num];
        String tmpTxt = "";
        int currentWordsNumber = 0;
        while (currentWordsNumber <= num) {
            for (String s : lipsum) {
                System.out.println("--------------------" + s);
                arrayResult[currentWordsNumber] = s + " ";
                currentWordsNumber++;

                if (currentWordsNumber == num) {
                    String stringResult = "";
                    for (String str : arrayResult) {
                        stringResult += str;
                    }
                    return stringResult;
                }
            }
        }
        return "error";
    }


    public String generateParagraphs(int num) {
        String[] lipsum = LIPSUM.split("\\.");
        String[] arrayResult = new String[num];
        String tmpTxt = "";
        Random r = new Random();
        int rnd = r.nextInt(300) + 200;
        int currentParagraphNumber = 0;
        while (currentParagraphNumber < num) {
            for (String s : lipsum) {
                if (tmpTxt.length() < rnd) {
                    tmpTxt += s + ".";
                } else {
                    arrayResult[currentParagraphNumber] = tmpTxt + "\n";
                    System.out.println("----------- " + arrayResult[currentParagraphNumber]);
                    tmpTxt = "";
                    rnd = r.nextInt(500) + 300;
                    currentParagraphNumber++;
                    if (currentParagraphNumber == num) {
                        break;
                    }

                }
            }
        }
        String stringResult = "";
        for (String s : arrayResult) {
            stringResult += s;
        }
        System.out.println(stringResult);
        return stringResult;
    }

    public String getLIPSUM() {
        return LIPSUM;
    }

    public String getLipsum() {
        return lipsum;
    }

    public void setLipsum(String lipsum) {
        this.lipsum = lipsum;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
