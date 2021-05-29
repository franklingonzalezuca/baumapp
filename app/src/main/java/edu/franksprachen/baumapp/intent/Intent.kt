package edu.franksprachen.baumapp.intent

sealed class Intent {
    object GetTreeEvent:Intent()
    object None:Intent()
}