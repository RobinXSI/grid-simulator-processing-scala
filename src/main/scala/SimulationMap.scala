import processing.core.PApplet

class SimulationMap(val grid: Vector[Vector[Cell]]) {

  def height: Int = grid.length
  def width: Int = grid(0).length

  override def toString: String = grid.map (line => line mkString " ") mkString "\n"



}
