package cs3500.pa05.model;


/**
 * Represents a theme of a BuJo
 */
public enum Theme {
  DEFAULT,
  DARK,
  COLORFUL;

  /**
   * Returns the string representation of this theme.
   *
   * @return the string representation of this theme
   */
  public String toString() {
    return switch (this) {
      case DEFAULT -> "DEFAULT";
      case DARK -> "DARK";
      case COLORFUL -> "COLORFUL";
    };
  }

  /**
   * Returns the theme represented by the given string.
   *
   * @param s the string representation of the theme
   * @return the theme represented by the given string
   */
  public static Theme fromString(String s) {
    return switch (s) {
      case "DEFAULT" -> DEFAULT;
      case "DARK" -> DARK;
      case "COLORFUL" -> COLORFUL;
      default -> throw new IllegalArgumentException("Invalid theme");
    };
  }
}
