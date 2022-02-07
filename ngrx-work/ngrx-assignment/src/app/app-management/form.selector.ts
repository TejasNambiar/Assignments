import { createSelector } from "@ngrx/store";
import { AppState } from "../app.state";
import { form } from "../entity/form";

export const DATA = (state:AppState) => state.formEnteries

export const FORM_DATA = createSelector(
    DATA,
    (formEnteries: form[]) => { 
        return formEnteries 
    }
)

