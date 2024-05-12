
//由于MainGuiData的结构特殊，所以无法继承

/*
* @author clok_
* @date 2024/4/5 12:22
*
* */
function MainGuiData(name) {
    //设置基本属性
    this.moduleID = name
    this.type = "Inventory"
    this.position = 0
    this.x = 0
    this.y = 0
    this.width = 200
    this.height = 150
    this.image = ""
    this.color = "0xffffff"
    this.transparent = "255"
    this.mask = "true"
    this.tooltip = ""
    this.MainGuiDataMap = new java.util.LinkedHashMap()
}
MainGuiData.prototype.toUnrealCore = () => {
    const a = new com.daxton.unrealcore.display.been.gui.MainGUIData()
    a.moduleDataMap = this.moduleDataMap
    a.x = this.x
    a.y = this.y
    a.width = this.width
    a.height = this.height
    a.image = this.image
    a.moduleID = this.moduleID
    a.type = this.type
    a.color = this.color
    a.transparent = this.transparent
    a.mask = this.mask
    a.tooltip = this.tooltip
    a.position = this.position
    return a
}
MainGuiData.prototype.addModuleData = (module) => {
    if (module instanceof ModuleData) {
        this.MainGuiDataMap.put(module.ModuleName, module.toJavaModule())
        return this
    }
    if (module instanceof com.daxton.unrealcore.display.been.module.ModuleData) {
        this.MainGuiDataMap.put(module.moduleID, module)
        return this
    }
    print("无效")
    return this
}

MainGuiData.prototype.getModuleID = () => this.moduleID

MainGuiData.prototype.setX = function(value){
    this.x = value
    return this
}

MainGuiData.prototype.setY = function(value){
    this.y = value
    return this
}

MainGuiData.prototype.setWidth = function(value){
    this.width = value
    return this
}

MainGuiData.prototype.setHeight = function(value){
    this.height = value
    return this
}

MainGuiData.prototype.setImage = function(value){
    this.image = value
    return this
}

MainGuiData.prototype.setColor = function(value){
    this.color = value
    return this
}


MainGuiData.prototype.setPosition = function(value){
    this.position = value
    return this
}


MainGuiData.prototype.setType = function(value){
    this.type = value
    return this
}

MainGuiData.prototype.getX = function() {
    return this.x;
};

MainGuiData.prototype.getY = function() {
    return this.y;
};

MainGuiData.prototype.getWidth = function() {
    return this.width;
};

MainGuiData.prototype.getHeight = function() {
    return this.height;
};

MainGuiData.prototype.getImage = function() {
    return this.image;
};

MainGuiData.prototype.getColor = function() {
    return this.color;
};

MainGuiData.prototype.getPosition = function() {
    return this.position;
};

MainGuiData.prototype.getType = function() {
    return this.type;
};

MainGuiData.prototype.getTransparent = () => this.transparent
MainGuiData.prototype.setTransparent = (value) => {
    this.transparent = value
    return this
}