/* Generated By:JJTree: Do not edit this line. ASTAxisSubset.java */

package org.geoserver.wcs.kvp.rangesubset;

public class ASTAxisSubset extends SimpleNode {
  public ASTAxisSubset(int id) {
    super(id);
  }

  public ASTAxisSubset(RangeSubsetParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(RangeSubsetParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
