function Wall() {
  this.upDivWrap = null 
  this.downDivWrap = null
  this.downHeight = baseObj.randomNum(0, 140)
  this.gapHeight = baseObj.randomNum(140, 190)
  this.upHeight = 312 - this.downDivWrap - this.gapHeight

  // 用生成div的方法来访墙体
  this.createDiv = function(url, height, positionType, left, top) {
    var newDiv = document.createElement('div')
    newDiv.style.width = '62px'
    newDiv.style.height = height
    newDiv.style.position = positionType
    newDiv.style.left = left
    newDiv.style.top = top
    newDiv.style.backgroundImage = url
    return newDiv
  }

  this.createWall = function() {
    var upDiv1 = this.createDiv('url(img/pie_up.png)', this.upHeight+'px')
    var upDiv2 = this.createDiv('url(img/pie_up.png)','60px')
    this.upDivWrap = this.createDiv(null, null, 'absolute', '450px')
    this.upDivWrap.appendChild(upDiv1)
    this.upDivWrap.appendChild(upDiv2) // 生成上方墙体

    var downDiv1 = this.createDiv('url(img/pie_down.png)', '60px')
    var downDiv2 = this.createDiv('url(img/pie_down.png', this.downHeight- 30 +'px')
    this.downDivWrap = this.createDiv(null, null, 'absolute', '450px', 363 - this.downHeight + 'px')
    this.downDivWrap.appendChild(downDiv1)
    this.downDivWrap.appendChild(downDiv2) // 生成下方墙体
    

    jsWrapBg.appendChild(this.upDivWrap)
    jsWrapBg.appendChild(this.downDivWrap)
  }

  this.moveWall = function() { // 控制墙体移动的方法
    this.upDivWrap.style.left = this.upDivWrap.offsetLeft - 3 + 'px'
    this.downDivWrap.style.left = this.downDivWrap.offsetLeft - 3 + 'px'
    
  }
}