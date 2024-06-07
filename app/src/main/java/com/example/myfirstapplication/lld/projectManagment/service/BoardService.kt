package com.example.myfirstapplication.lld.projectManagment.service

import com.example.myfirstapplication.lld.projectManagment.module.Board
import com.example.myfirstapplication.lld.projectManagment.module.BoardList
import com.example.myfirstapplication.lld.projectManagment.module.Card
import com.example.myfirstapplication.lld.projectManagment.enums.PRIORITY
import com.example.myfirstapplication.lld.projectManagment.enums.PRIVACY
import com.example.myfirstapplication.lld.projectManagment.module.User
import java.util.UUID

internal class BoardService {
    private val managementBoard: MutableList<Board> = mutableListOf()

    //**********************Board related functions*******************************

    fun createBoard(name: String): Board {
        val board =
            Board(id = UUID.randomUUID().toString(), name = name, url = "www.jira.com")
        managementBoard.add(board)
        return board
    }

    fun deleteBoard(boardID: String): Boolean {
        val requiredBoard = getBoardOfGivenID(boardID)
        if (requiredBoard != null) {
            managementBoard.remove(requiredBoard)
            return true
        } else return false
    }

    fun addMemberInBoard(user: User, boardId: String) {
        val requiredBoard = getBoardOfGivenID(boardId)

        if (getUserWithGivenID(user.userId, boardId) != null) {
        } else requiredBoard?.members?.add(user)
    }

    fun removeMemberFromBoard(userId: String, boardID: String) {
        val requiredBoard = getBoardOfGivenID(boardID)
        val requiredUser = getUserWithGivenID(userId, boardID)
        requiredBoard?.members?.remove(requiredUser)
    }

    fun showBoard(boardId: String) {
        val requiredBoard = getBoardOfGivenID(boardId)
        println(requiredBoard)
    }

    fun changePrivacyOfBoard(boardId: String, newPrivacy: PRIVACY) {
        val requiredBoard = getBoardOfGivenID(boardId)
        if (requiredBoard != null) {
            requiredBoard.privacy = newPrivacy
        }
    }

    // ****************** Card related operation **************************
    fun createCard(
        cardName: String,
        cardDescription: String = "New Card",
        boardId: String,
        listId: String
    ): Card {
        val newCard =
            Card(id = UUID.randomUUID().toString(), name = cardName, description = cardDescription)
        val requiredList = getListWithGivenID(boardId, listId)
        requiredList?.cards?.add(newCard)
        return newCard
    }

    fun assignUserToCard(newUser: User, boardId: String, listId: String, cardID: String) {
        val requiredList = getListWithGivenID(boardId, listId)
        val requiredCard = requiredList?.let { getCardWithGivenID(it, cardID) }
        if (requiredCard != null) {
            requiredCard.assignedTo = newUser
        }
    }

    fun deleteCard(cardID: String, boardId: String, listId: String) {
        val requiredList = getListWithGivenID(boardId, listId)
        val requiredCard = requiredList?.let { getCardWithGivenID(it, listId) }
        requiredList?.cards?.remove(requiredCard)
    }

    fun moveCardToOtherList(cardID: String, boardID: String, listIDTo: String, listIDFrom: String) {
        val requiredList = getListWithGivenID(boardID, listIDTo)
        val requiredCard = requiredList?.let { getCardWithGivenID(it, cardID) }
        removeCardFromCurrentList(requiredList, requiredCard)
        val requiredListToInsertCard = getListWithGivenID(boardID, listIDFrom)
        if (requiredCard != null) {
            requiredListToInsertCard?.cards?.add(requiredCard)
        }
    }

    fun changePriorityOfCard(
        boardId: String,
        listId: String,
        cardID: String,
        newPriority: PRIORITY
    ) {
        val requiredList = getListWithGivenID(boardId, listId)
        val requiredCard = requiredList?.let { getCardWithGivenID(it, cardID) }
        if (requiredCard != null) {
            requiredCard.priority = newPriority
        }
    }

    fun showCard(cardID: String, listId: String, boardId: String) {
        val requiredList = getListWithGivenID(boardId, listId)
        val requiredCard = requiredList?.let { getCardWithGivenID(it, cardID = cardID) }
        println(requiredCard)
    }

    // ***********************Board List Operation ***********************************

    fun createList(boardId: String, listName: String): BoardList {
        val requireBoard = getBoardOfGivenID(boardId)
        val newBoardList = BoardList(id = UUID.randomUUID().toString(), name = listName)
        requireBoard?.lists?.add(newBoardList)
        return newBoardList
    }

    fun deleteList(boardId: String, listId: String) {
        val requiredBoard = getBoardOfGivenID(boardId)
        val requiredList = getListWithGivenID(boardId, listId)
        requiredBoard?.lists?.remove(requiredList)
    }

    fun showList(boardId: String, listId: String) {
        val requiredList = getListWithGivenID(boardId, listId)
        println(requiredList)
    }

    // *********************** Private internal functions *******************************

    private fun removeCardFromCurrentList(requiredList: BoardList?, requiredCard: Card?) {
        requiredList?.cards?.remove(requiredCard)
    }

    private fun getCardWithGivenID(list: BoardList, cardID: String): Card? {
        var requiredCard: Card? = null
        for (currentCard in list.cards) {
            if (currentCard.id == cardID) {
                requiredCard = currentCard
                break
            }
        }
        return requiredCard
    }


    private fun getListWithGivenID(boardId: String, listId: String): BoardList? {
        val requiredBoard = getBoardOfGivenID(boardId)
        var requiredList: BoardList? = null
        if (requiredBoard != null) {
            for (currentList in requiredBoard.lists) {
                if (currentList.id == listId) {
                    requiredList = currentList
                }
            }
        }
        return requiredList
    }

    private fun getUserWithGivenID(userId: String, boardId: String): User? {
        val requiredBoard = getBoardOfGivenID(boardId)
        var requiredUser: User? = null
        if (requiredBoard != null) {
            for (member in requiredBoard.members) {
                if (member.userId == userId) {
                    requiredUser = member
                    break
                }
            }
        }
        return requiredUser
    }

    /**
     * Retrieves the board with the specified ID from the list of all boards.
     *
     * @param id The ID of the board to be retrieved.
     * @return The board with the given ID if found, or null if no such board exists.
     * @owner: Shiv Sagar Singh
     */
    private fun getBoardOfGivenID(id: String): Board? {
        var requiredBoard: Board? = null
        for (boardItem in managementBoard) {
            if (boardItem.id == id) {
                requiredBoard = boardItem
                break
            }
        }
        return requiredBoard
    }
}