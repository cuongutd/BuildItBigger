package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeSupplier {
    private List<String> jokes = new ArrayList<String>();

    public JokeSupplier(){

        //from sof...
        jokes.add(0, "A skeleton walks into a bar, orders a beer, and a mop");
        jokes.add(1, "Why do java programmers wear glasses? Beceause they don't C#");
        jokes.add(2, "A man flying in a hot air balloon suddenly realizes he’s lost. He reduces height and spots a man down below. He lowers the balloon further and shouts to get directions, \"Excuse me, can you tell me where I am?\"\n" +
                "The man below says: \"Yes. You're in a hot air balloon, hovering 30 feet above this field.\"\n" +
                "\"You must work in Information Technology,\" says the balloonist.\n" +
                "\"I do\" replies the man. \"How did you know?\"\n" +
                "\"Well,\" says the balloonist, \"everything you have told me is technically correct, but It's of no use to anyone.\"\n" +
                "The man below replies, \"You must work in management.\"\n" +
                "\"I do,\" replies the balloonist, \"But how'd you know?\"*\n" +
                "\"Well\", says the man, \"you don’t know where you are or where you’re going, but you expect me to be able to help. You’re in the same position you were before we met, but now it’s my fault.\"");
        jokes.add(3, "Two friends, Java and C, are sitting in a bar late one night having a chat. Intrigued by their exotic languages, a steady stream of guys have been walking over to hit on them. However, they're all paying a lot more attention to Java, leaving poor C stuck in a loop back and forth to the bar.\n" +
                "After a few more iterations, C's feeling a little tipsy. Eventually, she plucks up some courage and asks the next guy why he's so keen on Java and not her.\n" +
                "He replies: \"It’s nothing personal C, really. I just prefer girls with a little more class.\"");
        jokes.add(4, "A guy is standing on the corner of the street smoking one cigarette after another. A lady walking by notices him and says\n" +
                "\"Hey, don't you know that those things can kill you? I mean, didn't you see the giant warning on the box?!\"\n" +
                "\"That's OK\" says the guy, puffing casually \"I'm a computer programmer\"\n" +
                "\"So? What's that got to do with anything?\"\n" +
                "\"We don't care about warnings. We only care about errors.\"");
        jokes.add(5, "Q: Why do programmers always mix up Halloween and Christmas?\n" +
                "A: Because Oct 31 == Dec 25!");
        jokes.add(6, "Q: \"Whats the object-oriented way to become wealthy?\"\n" +
                "A: Inheritance");
        jokes.add(7, "To understand what recursion is, you must first understand recursion.");
        jokes.add(8, "What did the suicidal function say? \"GOODBYE WORLD\"");
        jokes.add(9, "How do functions break up? \"They stop calling each other!\"");

    }


    public String getAJoke(){
        Random random = new Random();
        return jokes.get(random.nextInt(10));
    }

}


