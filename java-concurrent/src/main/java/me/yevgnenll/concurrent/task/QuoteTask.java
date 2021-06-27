package me.yevgnenll.concurrent.task;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

public class QuoteTask implements Callable<TravelQuote> {
    private final TravelCompany company;
    private final TravelInfo travelInfo;

    public QuoteTask(TravelCompany company, TravelInfo travelInfo) {
        this.company = company;
        this.travelInfo = travelInfo;
    }

    TravelQuote getFailureQuote(Throwable t) {
        return null;
    }

    TravelQuote getTimeoutQuote(CancellationException e) {
        return null;
    }

    public TravelQuote call() throws Exception {
        return company.solicitQuote(travelInfo);
    }
}

