package de.focus_shift.jollyday.core.parser.functions;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.function.IntFunction;
import java.util.stream.Stream;

import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;

public class CalculateRelativeDatesFromChronologyWithinGregorianYear implements IntFunction<Stream<LocalDate>> {

  private final int targetMonth;
  private final int targetDay;
  private final Chronology targetChrono;
  private final int relativeShift;

  public CalculateRelativeDatesFromChronologyWithinGregorianYear(int targetMonth, int targetDay, Chronology targetChrono, int relativeShift) {
    this.targetMonth = targetMonth;
    this.targetDay = targetDay;
    this.targetChrono = targetChrono;
    this.relativeShift = relativeShift;
  }

  @Override
  public Stream<LocalDate> apply(final int gregorianYear) {
    final int absoluteShift = Math.abs(relativeShift);

    final LocalDate firstGregorianDate = LocalDate.of(gregorianYear, JANUARY, 1);
    final LocalDate lastGregorianDate = LocalDate.of(gregorianYear, DECEMBER, 31);

    final ChronoLocalDate firstTargetDate = targetChrono.date(firstGregorianDate.minusDays(absoluteShift));
    final ChronoLocalDate lastTargetDate = targetChrono.date(lastGregorianDate.plusDays(absoluteShift));

    int targetYear = firstTargetDate.get(ChronoField.YEAR);
    final int lastYear = lastTargetDate.get(ChronoField.YEAR);

    Stream.Builder<LocalDate> builder = Stream.builder();
    while (targetYear <= lastYear) {
      final ChronoLocalDate date = targetChrono.date(targetYear, targetMonth, targetDay).plus(relativeShift, ChronoUnit.DAYS);
      if (!firstGregorianDate.isAfter(date) && !lastGregorianDate.isBefore(date)) {
        builder.accept(LocalDate.from(date));
      }
      targetYear++;
    }
    return builder.build();
  }
}
