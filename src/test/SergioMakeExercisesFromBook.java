/*
 * Copyright (c) 2016.
 */

package test;

import java.util.*;

/**
 * Created by Valko Serhii on 03.03.2016.
 */
public class SergioMakeExercisesFromBook
{
    private int a = 6;
    private static boolean maybeEnough(List<String> completedTasks, List<String> allTasks)
    {
        int max = (int) (allTasks.size() * 0.25);
        int min = (int) (allTasks.size() * 0.6);
        if (completedTasks.size() > max)
        {
            System.out.println("Stop working, that's enough");
            System.exit(1);
        }
        return completedTasks.size() >= min || completedTasks.size() <= max;
    }

    public static void main(String... args) throws Exception
    {
        List<String> allTasks = new ArrayList<>();
        allTasks.addAll(Arrays.asList(args));
        List<String> completedTasks = new ArrayList<>(allTasks.size());

        for (String task : allTasks)
        {
            completedTasks.add(doExercise(task));
            if (maybeEnough(completedTasks, allTasks))
            {
                break;
            }
        }
    }

    private static String doExercise(String task) throws Exception
    {
        Thread.sleep(new Random().nextLong());
        System.out.println("I've done task: " + task);
        return task;
    }
}
