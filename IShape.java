public class IShape {
  int colOrigin;  
  int rowOrigin;
  int col0;
  int row0;
  int col1;
  int row1;
  int col2;
  int row2;
  int direction; // 0: EAST 1: SOUTH 2: WEST 3: NORTH
  Grid grid;
  
  public void initPointsFromOrigin(int initCol, int initRow) {
    colOrigin = initCol;
    rowOrigin = initRow;
    col0 = initCol;
    row0 = initRow + 1;
    col1 = initCol;
    row1 = initRow - 1;
    col2 = initCol;
    row2 = initRow - 2;
    direction = 0;
  }
  
  public boolean moveDown() {
    if (direction == 0) {
      boolean check0Down =
        grid.isEmpty(col0, row0 + 1) &&
        grid.isInBounds(col0, row0 + 1);
        
      if(check0Down) {
        ++rowOrigin;
        ++row0;
        ++row1;
        ++row2;
        
        return true;
      }
    } else if (direction == 1 || direction == 3) {
        boolean check0Down =
          grid.isEmpty(col0, row0 + 1) &&
          grid.isInBounds(col0, row0 + 1);
        
        boolean check1Down =
          grid.isEmpty(col1, row1 + 1) &&
          grid.isInBounds(col1, row1 + 1);
          
        boolean check2Down =
          grid.isEmpty(col2, row2 + 1) &&
          grid.isInBounds(col2, row2 + 1);
        
        boolean checkOriginDown =
          grid.isEmpty(colOrigin, rowOrigin + 1) &&
          grid.isInBounds(colOrigin, rowOrigin + 1);
        
        if(check0Down && check1Down && check2Down) {
          ++rowOrigin;
          ++row0;
          ++row1;
          ++row2;
        
        return true;
        }
    } else if (direction == 2) {
        boolean check2Down =
          grid.isEmpty(col2, row2 + 1) &&
          grid.isInBounds(col2, row2 + 1);
        
        if(check2Down) {
          ++rowOrigin;
          ++row0;
          ++row1;
          ++row2;
        
          return true;
        }
    }
    
    return false;
  }
  
  public boolean moveLeft() {
    if (direction == 0 || direction == 2) {
      boolean check1Left =
        grid.isEmpty(col1 - 1, row1) &&
        grid.isInBounds(col1 - 1, row1);
      
      boolean check0Left =
        grid.isEmpty(col0 - 1, row0) &&
        grid.isInBounds(col0 - 1, row0);
        
      boolean checkOriginLeft =
        grid.isEmpty(colOrigin - 1, rowOrigin) &&
        grid.isInBounds(colOrigin - 1, rowOrigin);
        
      boolean check2Left =
        grid.isEmpty(col2 - 1, row2) &&
        grid.isInBounds(col2 - 1, row2);
        
      if (check0Left && check1Left && check2Left && checkOriginLeft) {
        --colOrigin;
        --col0;
        --col1;
        --col2;
        
        return true;
      }
    } else if (direction == 1) {
      boolean check0Left =
        grid.isEmpty(col0 - 1, row0) &&
        grid.isInBounds(col0 - 1, row0);
      
      if (check0Left) {
        --colOrigin;
        --col0;
        --col1;
        --col2;
        
        return true;
      }
    } else if (direction == 3) {
      boolean check2Left =
        grid.isEmpty(col2 - 1, row2) &&
        grid.isInBounds(col2 - 1, row2);
      
      if (check2Left) {
        --colOrigin;
        --col0;
        --col1;
        --col2;
        
        return true;
      }
    }
    
    return false;
  }
  
  public boolean moveRight() {
    if (direction == 0 || direction == 2) {
      boolean check1Right =
        grid.isEmpty(col1 + 1, row1) &&
        grid.isInBounds(col1 + 1, row1);
      
      boolean check0Right =
        grid.isEmpty(col0 + 1, row0) &&
        grid.isInBounds(col0 + 1, row0);
        
      boolean checkOriginRight =
        grid.isEmpty(colOrigin + 1, rowOrigin) &&
        grid.isInBounds(colOrigin + 1, rowOrigin);
        
      boolean check2Right =
        grid.isEmpty(col2 + 1, row2) &&
        grid.isInBounds(col2 + 1, row2);
        
      if (check0Right && check1Right && check2Right && checkOriginRight) {
        ++colOrigin;
        ++col0;
        ++col1;
        ++col2;
        
        return true;
      }
    } else if (direction == 1) {
      boolean check2Right =
        grid.isEmpty(col2 + 1, row2) &&
        grid.isInBounds(col2 + 1, row2);
      
      if (check2Right) {
        ++colOrigin;
        ++col0;
        ++col1;
        ++col2;
        
        return true;
      }
    } else if (direction == 3) {
      boolean check0Right =
        grid.isEmpty(col0 + 1, row0) &&
        grid.isInBounds(col0 + 1, row0);
      
      if (check0Right) {
        ++colOrigin;
        ++col0;
        ++col1;
        ++col2;
        
        return true;
      }
    }
    
    return false;
  }
  
  public boolean rotate() {
    if (direction == 0) {
      boolean check0Rotate =
        grid.isEmpty(col0 - 1, row0 - 1) &&
        grid.isInBounds(col0 - 1, row0 - 1);
      
      boolean check1Rotate =
        grid.isEmpty(col1 + 1, row1 + 1) &&
        grid.isInBounds(col1 + 1, row1 + 1);
      
      boolean check2Rotate =
        grid.isEmpty(col2 + 2, row2 + 2) &&
        grid.isInBounds(col2 + 2, row2 + 2);
      
      if (check0Rotate && check1Rotate && check2Rotate) {
        --col0;
        --row0;
        ++col1;
        ++row1;
        col2 = col2 + 2;
        row2 = row2 + 2;
        
        direction = 1;
        
        return true;
      }
    } else if (direction == 1) {
      boolean check0Rotate =
        grid.isEmpty(col0 + 1, row0 - 1) &&
        grid.isInBounds(col0 + 1, row0 - 1);
        
      boolean check1Rotate =
        grid.isEmpty(col1 - 1, row1 + 1) &&
        grid.isInBounds(col1 - 1, row1 + 1);
      
      boolean check2Rotate =
        grid.isEmpty(col2 - 2, row2 + 2) &&
        grid.isInBounds(col2 - 2, row2 + 2);
      
      if (check0Rotate && check1Rotate && check2Rotate) {
        ++col0;
        --row0;
        --col1;
        ++row1;
        col2 = col2 - 2;
        row2 = row2 + 2;
        
        direction = 2;
        
        return true;
      }
    } else if (direction == 2) {
      boolean check0Rotate =
        grid.isEmpty(col0 + 1, row0 + 1) &&
        grid.isInBounds(col0 + 1, row0 + 1);
      
      boolean check1Rotate =
        grid.isEmpty(col1 - 1, row1 - 1) &&
        grid.isInBounds(col1 - 1, row1 - 1);
      
      boolean check2Rotate =
        grid.isEmpty(col2 - 2, row2 - 2) &&
        grid.isInBounds(col2 - 2, row2 - 2);
        
      if (check0Rotate && check1Rotate && check2Rotate) {
        ++col0;
        ++row0;
        --col1;
        --row1;
        col2 = col2 - 2;
        row2 = row2 - 2;
        
        direction = 3;
        
        return true;
      }
    } else if (direction == 3) {
      boolean check0Rotate =
        grid.isEmpty(col0 - 1, row0 + 1) &&
        grid.isInBounds(col0 - 1, row0 + 1);
      
      boolean check1Rotate =
        grid.isEmpty(col1 + 1, row1 - 1) &&
        grid.isInBounds(col1 + 1, row1 - 1);
      
      boolean check2Rotate =
        grid.isEmpty(col2 + 2, row2 - 2) &&
        grid.isInBounds(col2 + 2, row2 - 2);
        
      if (check0Rotate && check1Rotate && check2Rotate) {
        --col0;
        ++row0;
        ++col1;
        --row1;
        col2 = col2 + 2;
        row2 = row2 - 2;
        
        direction = 0;
        
        return true;
      }
    }
    
    return false;
  }
}