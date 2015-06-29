/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package allapotter;

/**
 *
 * @author panovics
 */
public class HibasOperatorException extends Exception
{

  @Override
  public String getMessage()
  {
    return "Ez az operator itt nem ertelmes!";
  }

}
