package com.example.movieday.domain;

public enum Region {

  USA("USA"), Europe("Europe"), Asia("Asia"), Other_Regions(
          "Other_Regions");
  private String label;
  private Region(String label) {
    this.label = label;
  }
  public static Region findByLabel(String byLabel) {
    for(Region r: Region.values()) {
      if (r.label.equalsIgnoreCase(byLabel))
        return r;
    }
    return null;
  }
}
