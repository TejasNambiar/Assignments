import { ActionReducer, createReducer, INIT, on, UPDATE } from "@ngrx/store"
import { Form } from "../entity/form"
import { ADD_DATA, CLEAR_LIST, REMOVE_DATA } from "./form.actions"

export const INIT_ENTERIES: Form[] = []

export const FORM_REDUCER = createReducer(
    INIT_ENTERIES,

    on(CLEAR_LIST, _ => []),

    on(ADD_DATA, (enteries, formData) => {
        return [...enteries, formData]
    }),

    on(REMOVE_DATA, (enteries, formData) => {
        // cloning as enteries(state in ngrx) immutable
        const DATA: Form[] = JSON.parse(JSON.stringify(enteries))
        console.log("data entered:: " + JSON.stringify(formData))
        console.log("before splice:: " + JSON.stringify(DATA))
        const object: Form[] = DATA.filter(x => x.username == formData.username)
            .filter(x => x.email == formData.email)
            .filter(x => x.phone == formData.phone)
        // console.log(" data found at index passed:: "+DATA.indexOf(object[0])+" is:: "+JSON.stringify(object[0]))
        DATA.splice(DATA.indexOf(object[0]), 1)
        return DATA
    })
)

export const metaReducerLocalStorage = (reducer: ActionReducer<any>): ActionReducer<any> => {
    return (state, action) => {
        /**
         * Check the type of action being performed (ADD, REMOVE, CLEAR)
         */
        if (action.type === INIT || action.type == UPDATE) {
            const STORAGE_VALUE = localStorage.getItem('state')
            if (STORAGE_VALUE) {
                /**
                 * try to get state from local storage
                 */
                try {
                    return JSON.parse(STORAGE_VALUE)
                } catch {
                    localStorage.removeItem("state")
                }
            }
        }
        /**
         * In all other cases, delegate the action to the actual reducer
         * store the state in the local storage and return the state 
         */
        const nextState = reducer(state, action)
        localStorage.setItem("state", JSON.stringify(nextState))
        return nextState
    }
}