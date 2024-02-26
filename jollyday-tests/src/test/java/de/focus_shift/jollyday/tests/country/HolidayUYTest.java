package de.focus_shift.jollyday.tests.country;

import de.focus_shift.jollyday.core.Holiday;
import de.focus_shift.jollyday.core.HolidayManager;
import de.focus_shift.jollyday.core.ManagerParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static de.focus_shift.jollyday.core.HolidayCalendar.URUGUAY;
import static org.assertj.core.api.Assertions.assertThat;

class HolidayUYTest extends AbstractCountryTestBase {

  private HolidayManager holidayManager;

  @BeforeEach
  void init() {
    holidayManager = HolidayManager.getInstance(ManagerParameters.create(URUGUAY));
  }

  @Test
  void testManagerUYStructure() {
    validateCalendarData("uy", 2016);
  }

  @Test
  void testManagerUYLanding33EasternersMovingDaysWhenLanding33EasternersOnTuesday() {
    final int year = 2016;
    final LocalDate landing33Easterners = LocalDate.of(year, 4, 18);
    assertThat(contains(landing33Easterners, holidayManager.getHolidays(year))).isTrue();
  }

  @Test
  void testManagerUYLanding33EasternersMovingDaysWhenLanding33EasternersOnThursday() {
    final int year = 2007;
    final LocalDate landing33Easterners = LocalDate.of(year, 4, 23);
    assertThat(contains(landing33Easterners, holidayManager.getHolidays(year))).isTrue();
  }

  @Test
  void testManagerUYRaceMovingDaysWhenRaceOnWednesday() {
    final int year = 2016;
    final LocalDate race = LocalDate.of(year, 10, 10);
    assertThat(contains(race, holidayManager.getHolidays(year))).isTrue();
  }

  @Test
  void testManagerUYRaceMovingDaysWhenRaceOnFriday() {
    final int year = 2007;
    final LocalDate race = LocalDate.of(year, 10, 15);
    assertThat(contains(race, holidayManager.getHolidays(year))).isTrue();
  }

  @Test
  void testManagerUYLasPiedrasMovingDaysWhenLasPiedrasOnTuesday() {
    final int year = 2016;
    final LocalDate lasPiedras = LocalDate.of(year, 5, 16);
    assertThat(contains(lasPiedras, holidayManager.getHolidays(year))).isTrue();
  }

  @Test
  void testManagerUYLasPiedrasMovingDaysWhenLasPiedrasOnFriday() {
    final int year = 2007;
    final LocalDate lasPiedras = LocalDate.of(year, 5, 21);
    assertThat(contains(lasPiedras, holidayManager.getHolidays(year))).isTrue();
  }

  private boolean contains(LocalDate localDate, Set<Holiday> holidays) {
    for (Holiday h : holidays) {
      if (localDate.equals(h.getDate())) {
        return true;
      }
    }
    return false;
  }
}
