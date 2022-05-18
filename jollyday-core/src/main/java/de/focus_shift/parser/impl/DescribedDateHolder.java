package de.focus_shift.parser.impl;

import de.focus_shift.spi.Described;

import java.time.LocalDate;

class DescribedDateHolder {

  private final LocalDate date;
  private final Described described;

  public DescribedDateHolder(Described described, LocalDate date) {
    this.date = date;
    this.described = described;
  }

  public LocalDate getDate() {
    return date;
  }

  public Described getDescribed() {
    return described;
  }
}
