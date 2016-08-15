import processing.core.PApplet

class SimulationMap(grid: Vector[Vector[Cell]]) {

  def height: Int = grid.length
  def width: Int = grid(0).length

  def calculateCellParameters(cell: Cell, canvas: PApplet) = {
    val cellSize = math.min(canvas.width / width, canvas.height / height)
    canvas.stroke(240)
    canvas.fill(255)
    canvas.rect(cell.coordinate.x * cellSize, cell.coordinate.y * cellSize, cellSize, cellSize)
  }

  def draw(canvas: PApplet) = for {
    cell <- grid.flatten
  } calculateCellParameters(cell, canvas)

  override def toString: String = grid.map (line => line mkString " ") mkString "\n"

}
