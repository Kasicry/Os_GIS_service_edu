/* Generated By:JJTree: Do not edit this line. ASTRangeSubset.java */

package org.geoserver.wcs.kvp.rangesubset;

public class ASTRangeSubset extends SimpleNode {
  public ASTRangeSubset(int id) {
    super(id);
  }

  public ASTRangeSubset(RangeSubsetParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(RangeSubsetParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
