function TextButton(name) {
    //继承
    ModuleData.call(this,name)
    this.texts = []
    this.font = ""
    this.space = ""
    this.textSize = ""
    this.textColor = ""
    this.moduleType = ModulesAPI.ModuleType.Text
}

//继承ModuleData得到ModuleData的方法和属性

TextButton.prototype.constructor = TextButton

//你必须重写它，因为这是一个抽象方法，直接使用会报错

TextButton.prototype.toJavaModule = () => {
    const text = find("com.daxton.unrealcore.display.been.module.display.TextModuleData")
    const text1 = new text()
    this.QST(text1)
    text1.font = this.font
    text1.space = this.space
    text1.textSize = this.textSize
    text1.textColor = this.textColor
    text1.text = arrayOf(this.texts)
    return text1
}

TextButton.prototype.builder = (data) => {
    const text = this.toJavaModule()
    add(data, text)
}

TextButton.prototype.setFont = (str) => {
    this.font = str
    return this
}

TextButton.prototype.setFontColor = (str) => {
    this.fontColor = str
    return this
}

//设置文本 必须为js 数组
TextButton.prototype.setTexts = (args) => {
    this.texts = args
    return this
}
//新增文本
TextButton.prototype.addText = (str) => {
    this.texts.push(str)
    return this
}
//过滤文本，为true则是剩下的
TextButton.prototype.filter = (condition) => {
    this.texts.filter((value) => {
        condition(value)
    })
    return this
}
