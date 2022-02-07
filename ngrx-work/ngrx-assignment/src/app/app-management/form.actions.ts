import { createAction, props } from "@ngrx/store";
import { form } from "../entity/form";

export const ADD_DATA = createAction('Add Data', props<form>())

export const REMOVE_DATA = createAction('Remove Data', props<form>())

export const CLEAR_LIST = createAction('Clear List')