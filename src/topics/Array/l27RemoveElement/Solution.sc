object Solution {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    var m = 0
    var i = 0
    while(i < nums.length) {
      if(nums(i) != `val`)
      {
        nums.update(m, nums(i))
        m = m + 1
      }
      i = i + 1
    }
    m
  }
}