const _ButtonModule_ = {
    module: find("com.daxton.unrealcore.display.type.ModuleType"),
    button: find("com.daxton.unrealcore.display.been.module.control.ButtonModuleData"),
    butt: find("com.daxton.unrealcore.display.content.module.control.ButtonModule")
}
load("plugins/UISystem/scripts/libs/button/AbstractButton.js")
function Button(name) {
    AbstractButton.call(this,name)
    this.ModuleName = name
    this.moduleType = _ButtonModule_.module.Button
}
Button.prototype = Object.create(AbstractButton.prototype);
Button.prototype.constructor = Button;


Button.prototype.toJavaModule = () => {
    const obj = new _ButtonModule_.button()
    this.toUnrealCore(obj)
    obj.image = this.image
    obj.hoverImage = this.hoverImage
    obj.hoverColor = this.hoverColor
    obj.hoverTransparent = this.hoverTransparent
    obj.clickImage = this.clickImage
    obj.clickColor = this.clickColor
    obj.text = this.text
    obj.textColor = this.textColor
    obj.textSize = this.textSize
    obj.use = this.use
    obj.font = this.font
    obj.moduleID = this.moduleID
    return obj
}



Button.prototype.builder = (data) => {
    const button = this.toJavaModule()
    if (this.unit.length === 0) return data.getMainGUIData().addModule(this.ModuleName,button)

    if(data.customData.get("ButtonModulesTrigger") == null) {
        data.customData.put("ButtonModulesTrigger", new java.util.HashMap())
        data.customData.get("ButtonModulesTrigger").put(this.moduleID, listOf(this.unit))
    } else {
        data.customData.get("ButtonModulesTrigger").put(this.moduleID, listOf(this.unit))
    }

    const a = new _ButtonModule_.butt(button)
    a.moduleID = this.ModuleName
    data.addModule(a)
    data.getMainGUIData().addModule(this.ModuleName,button)
}

Button.CreateHandler = (data,buttonModule,button,action) => {
    data.customData.get("ButtonModulesTrigger").get(buttonModule.moduleID).forEach((value) => {
        value({
            data: data,
            buttonModule: buttonModule,
            button: button,
            action: action
        })
    })
}