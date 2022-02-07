import { createReducer, on } from "@ngrx/store";
import { Course } from "../entity/course";
import { ADD_COURSE, CLEAR_LIST, REMOVE_COURSE } from "./list.actions";

export const INITIAL_ENTRIES: Course[] = []

export const LIST_REDUCER = createReducer(
    INITIAL_ENTRIES,

    on(ADD_COURSE, (entries, course) =>{
        const ENTRIES_CLONE: Course[] = JSON.parse(JSON.stringify(entries))
        ENTRIES_CLONE.push(course)
        return ENTRIES_CLONE
    }),

    on(REMOVE_COURSE, (entries, course) =>{
        const ENTRIES_CLONE: Course[] = JSON.parse(JSON.stringify(entries))
        console.log("before splice:: "+ENTRIES_CLONE)
        console.log("index of course:: "+course.name+" is:: "+ENTRIES_CLONE.indexOf(course))
        ENTRIES_CLONE.splice(ENTRIES_CLONE.indexOf(course),1)
        console.log("After splice:: "+ENTRIES_CLONE+" now length:: "+ENTRIES_CLONE.length)
        return ENTRIES_CLONE
    }),

    on(CLEAR_LIST, _ => [])
)