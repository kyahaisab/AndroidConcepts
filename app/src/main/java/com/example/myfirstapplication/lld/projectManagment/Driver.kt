package com.example.myfirstapplication.lld.projectManagment

import com.example.myfirstapplication.lld.projectManagment.enums.PRIORITY
import com.example.myfirstapplication.lld.projectManagment.enums.PRIVACY
import com.example.myfirstapplication.lld.projectManagment.module.User
import com.example.myfirstapplication.lld.projectManagment.service.BoardService


fun main() {
    val boardService = BoardService()
    val newBoard = boardService.createBoard("Profit Tracking Board")

    val userNaren = User(email = "Narensagarhbtu@gmail.com", name = "Naren")
    val userSagar = User(email = "Shivsagarhbtu@gmail.com", name = "Shiv Sagar Singh")
    boardService.addMemberInBoard(userNaren, newBoard.id)

    val startTaskList = boardService.createList(newBoard.id, "Start Task List")
    val progressTaskList = boardService.createList(newBoard.id, "Progress Task List")

    val petrolProfitCard = boardService.createCard(
        "Petrol Profit",
        "Track profit generated from selling petrol",
        newBoard.id,
        startTaskList.id
    )
    val liquorProfitCard = boardService.createCard(
        "Liquor Profit",
        "Track profit generated from selling Country Liquor",
        newBoard.id,
        startTaskList.id
    )

    boardService.showBoard(boardId = newBoard.id)

    boardService.assignUserToCard(
        userSagar,
        newBoard.id,
        startTaskList.id,
        cardID = petrolProfitCard.id
    )
    boardService.assignUserToCard(
        userNaren,
        newBoard.id,
        startTaskList.id,
        cardID = liquorProfitCard.id
    )

    boardService.moveCardToOtherList(
        liquorProfitCard.id,
        newBoard.id,
        startTaskList.id,
        progressTaskList.id
    )

    boardService.run {
        changePrivacyOfBoard(newBoard.id, PRIVACY.PRIVATE)
        changePriorityOfCard(newBoard.id, progressTaskList.id, petrolProfitCard.id, PRIORITY.HIGH)
        showCard(liquorProfitCard.id, progressTaskList.id, newBoard.id)

        showList(newBoard.id, progressTaskList.id)
    }
}
