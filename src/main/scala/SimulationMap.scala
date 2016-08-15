import processing.core.PApplet

class SimulationMap(grid: Vector[Vector[Cell]]) {

  def height: Int = grid.length
  def width: Int = grid(0).length
  var canvas: PApplet = _

  def calculateCellParameters(cell: Cell, canvas: PApplet) = {
    val cellSize = math.min(canvas.width / (width + 0.5) , canvas.height / (height + 0.5))
    this.canvas = canvas
    canvas.stroke(240)
    canvas.fill(255)
    createHexagon(cell.coordinate, cellSize)
  }


  def widthToRadius(width: Double): Double = width / math.sqrt(3)

  def hexCorner(center: Coordinate, width: Double, i: Integer) = {
    val angleDegree = 60 * i + 30
    val angleRadiant = Math.PI / 180 * angleDegree
    val radius = widthToRadius(width)

    val x = (center.x * width) + radius * math.cos(angleRadiant) + width / 2
    val y = (center.y * radius * 3 / 4 * 2) + radius * math.sin(angleRadiant) + radius

    if (center.y % 2 == 0) Coordinate(x.toInt, y.toInt)
    else Coordinate((x + width / 2).toInt, y.toInt)
  }

  def createHexagon(center: Coordinate, width: Double) = {
    val numberOfEdges = 6
    canvas.beginShape()
    for (i <- 1 to numberOfEdges) {
      val corner = hexCorner(center, width, i)
      canvas.vertex(corner.x, corner.y)
    }
    canvas.endShape()
  }

  def draw(canvas: PApplet) = for {
    cell <- grid.flatten
  } calculateCellParameters(cell, canvas)

  override def toString: String = grid.map (line => line mkString " ") mkString "\n"

}
