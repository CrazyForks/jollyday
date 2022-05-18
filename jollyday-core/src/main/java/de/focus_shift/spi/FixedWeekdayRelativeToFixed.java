package de.focus_shift.spi;

import java.time.DayOfWeek;

public interface FixedWeekdayRelativeToFixed extends Described, Limited {
  Fixed day();

  Occurrance which();

  DayOfWeek weekday();

  Relation when();
}
