window.onload = function() {
  imgLocation("container", "box")
}

// 获取当前有多少张图片要摆放
function imgLocation(parent, content) {
  // 将parent下的所有内容全部取出
  var cparent = document.getElementById(parent)
  // console.log(cparent)
  var ccontent = getChildElement(cparent, content)
  // console.log(ccontent)
  var imgWidth = ccontent[0].offsetWidth
  var num = Math.floor(document.documentElement.clientWidth / imgWidth)
  cparent.style.cssText = "width:" + imgWidth * num + "px"

  var BoxHeightArr = []
  for (var i = 0; i < ccontent.length; i++) {
    if (i < num){
      BoxHeightArr[i] = ccontent[i].offsetHeight
      // console.log(BoxHeightArr[i])
    } else {
      // 将Math.min方法借给数组用
      var minHeight = Math.min.apply(null, BoxHeightArr)
      var minIndex = getMinHeightLocation(BoxHeightArr, minHeight)
      // console.log(minHeight)
      ccontent[i].style.position = 'absolute'
      ccontent[i].style.top = minHeight + 'px'
      ccontent[i].style.left = ccontent[minIndex].offsetLeft + 'px'
      BoxHeightArr[minIndex] = ccontent[i].offsetHeight + BoxHeightArr[minIndex]
    }
  }
}

// 获取父容器中的所有子容器
function getChildElement(cparent, content){
  var contentArr = []
  var allContent = cparent.getElementsByTagName('*')
  // console.log(allContent)
  for (var i = 0; i < allContent.length; i++) {
    if (allContent[i].className == content) {
        contentArr.push(allContent[i])
    }
  }
  return contentArr
}

// 获取高度最小的图片所在数组的下标
function getMinHeightLocation(BoxHeightArr, minHeight){
  for (var i in BoxHeightArr) {
    if (BoxHeightArr[i] === minHeight) {
      return i;
    }
  }
}
