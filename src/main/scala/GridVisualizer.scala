import processing.core.PApplet

class GridVisualizer(canvas: PApplet) {

  def draw(simulationMap: SimulationMap) = for {
    cell <- simulationMap.grid.flatten
  } calculateCellParameters(simulationMap, cell)

  def calculateCellParameters(simulationMap: SimulationMap, cell: Cell) = {
    val cellSize = math.min(canvas.width / (simulationMap.width + 0.5) , canvas.height / (simulationMap.height + 0.5))
    canvas.stroke(240)
    canvas.fill(255)
    createHexagon(cell.coordinate, cellSize, cell.state)
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

  def createHexagon(center: Coordinate, width: Double, state: CellState) = {
    val numberOfEdges = 6

    state match {
      case Wall => canvas.fill(0)
      case Empty => canvas.fill(255)
    }


    canvas.beginShape()
    for (i <- 1 to numberOfEdges) {
      val corner = hexCorner(center, width, i)
      canvas.vertex(corner.x, corner.y)
    }
    canvas.endShape()
  }

}
