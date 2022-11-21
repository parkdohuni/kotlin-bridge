package bridge

fun main() {
    val bridgeMaker: BridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridgeSize: Int = InputView().readBridgeSize()
    val bridge: List<String> = bridgeMaker.makeBridge(bridgeSize)
    val bridgeGame: BridgeGame = BridgeGame(bridge)
    gameStart(bridgeGame, bridgeSize)
}

fun gameStart(bridgeGame: BridgeGame, bridgeSize: Int) {
    var count = 0
    while (bridgeGame.endGame()) {
        if(bridgeSize == count) return gameEnd(bridgeGame)
        val readMoving: String = InputView().readMoving()// 위칸 아래칸
        bridgeGame.move(readMoving)
        bridgeGame.printMap()
        count += 1
    }
}

fun gameEnd(bridgeGame: BridgeGame) {
    println("\n최종 게임 결과")
    bridgeGame.printMap()
    bridgeGame.printResult()
}