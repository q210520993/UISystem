const __TextModuleFind__ = {
    module: find("com.daxton.unrealcore.display.type.ModuleType"),
    text: find("com.daxton.unrealcore.display.been.module.display.TextModuleData")
}
load("plugins/UISystem/scripts/libs/core/Modules/Modules.js")
function TextModule(name) {
    //继承
    ModuleData.call(this,name)
    this.ModuleName = name
    this.texts = []
    this.font = "0"
    this.space = "10"
    this.textSize = "1"
    this.textColor = "6821a9"
    this.moduleType = __TextModuleFind__.module.Text
}
TextModule.prototype = Object.create(ModuleData.prototype);
TextModule.prototype.constructor = TextModule

//你必须重写它，因为这是一个抽象方法，直接使用会报错

TextModule.prototype.toJavaModule = () => {
    const text1 = new __TextModuleFind__.text()
    this.toUnrealCore(text1)
    text1.text = listOf(this.texts)
    text1.space = this.space
    text1.textColor = this.textColor
    text1.font = 0
    text1.position = 1
    return text1
}

TextModule.prototype.builder = (data) => {
    const text = this.toJavaModule()
    data.getMainGUIData().addModule(this.ModuleName,text)
}

TextModule.prototype.setSpace = (str) => {
    this.space = str
    return this
}


TextModule.prototype.setModuleID = (str) => {
    this.moduleID = str
    return this
}

TextModule.prototype.setFont = (str) => {
    this.font = str
    return this
}

TextModule.prototype.setFontColor = (str) => {
    this.fontColor = str
    return this
}

//设置文本 必须为js 数组
TextModule.prototype.setTexts = (args) => {
    this.texts = args
    return this
}
//新增文本
TextModule.prototype.addText = (str) => {
    this.texts.push(str)
    return this
}
//过滤文本，为true则是剩下的
TextModule.prototype.filter = (condition) => {
    this.texts.filter((value) => {
        condition(value)
    })
    return this
}
