/* Generated By:JJTree: Do not edit this line. C:\01.Kasi\06.repository\geoserver\src\wcs1_1\target\jjtree\org\geoserver\wcs\kvp\rangesubset\RangeSubsetParserVisitor.java */

package org.geoserver.wcs.kvp.rangesubset;

public interface RangeSubsetParserVisitor
{
  public Object visit(SimpleNode node, Object data);
  public Object visit(ASTRangeSubset node, Object data);
  public Object visit(ASTFieldSubset node, Object data);
  public Object visit(ASTAxisSubset node, Object data);
  public Object visit(ASTFieldId node, Object data);
  public Object visit(ASTAxisId node, Object data);
  public Object visit(ASTInterpolation node, Object data);
  public Object visit(ASTKey node, Object data);
}
