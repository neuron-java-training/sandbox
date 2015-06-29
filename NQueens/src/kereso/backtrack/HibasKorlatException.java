package kereso.backtrack;

public class HibasKorlatException extends Exception
{
  @Override
  public String toString()
  {
    return "A korlat nem pozitiv szam!";
  }
}
