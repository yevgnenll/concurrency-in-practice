package me.yevgnenll.concurrent.task;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class TimeBudget {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    public List<TravelQuote> getRankedTravelQuotes(TravelInfo travelInfo,
           Set<TravelCompany> companies, Comparator<TravelQuote> ranking,
                           long time, TimeUnit unit) throws InterruptedException {

        List<QuoteTask> tasks = companies.stream()
                .map(company -> new QuoteTask(company, travelInfo))
                .collect(Collectors.toList());
        List<Future<TravelQuote>> futures = exec.invokeAll(tasks, time, unit);

        List<TravelQuote> quotes = new ArrayList<>(tasks.size());
        Iterator<QuoteTask> taskIter = tasks.iterator();
        for (Future<TravelQuote> f : futures) {
            QuoteTask task = taskIter.next();
            try {
                quotes.add(f.get());
            } catch (ExecutionException e) {
                quotes.add(task.getFailureQuote(e.getCause()));
            } catch (CancellationException e) {
                quotes.add(task.getTimeoutQuote(e));
            }
        }

        Collections.sort(quotes, ranking);
        return quotes;
    }
}
