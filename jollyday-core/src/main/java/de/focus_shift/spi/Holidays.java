package de.focus_shift.spi;

import java.util.List;

public interface Holidays {

  List<Fixed> fixed();

  List<RelativeToFixed> relativeToFixed();

  List<RelativeToWeekdayInMonth> relativeToWeekdayInMonth();

  List<FixedWeekdayInMonth> fixedWeekdays();

  List<ChristianHoliday> christianHolidays();

  List<IslamicHoliday> islamicHolidays();

  List<FixedWeekdayBetweenFixed> fixedWeekdayBetweenFixed();

  List<FixedWeekdayRelativeToFixed> fixedWeekdayRelativeToFixed();

  List<HinduHoliday> hinduHolidays();

  // TODO: ? is this used anywhere?
  // Stream<HebrewHoliday> hebrewHolidays();

  List<EthiopianOrthodoxHoliday> ethiopianOrthodoxHolidays();

  List<RelativeToEasterSunday> relativeToEasterSunday();

}
