/* Generated By:JJTree: Do not edit this line. ASTFieldId.java */

package org.geoserver.wcs.kvp.rangesubset;

public class ASTFieldId extends SimpleNode {
  public ASTFieldId(int id) {
    super(id);
  }

  public ASTFieldId(RangeSubsetParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(RangeSubsetParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
