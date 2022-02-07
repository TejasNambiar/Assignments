import { createAction, props } from "@ngrx/store";
import { Form } from "../entity/form";

export const ADD_DATA = createAction('Add Data', props<Form>())

export const REMOVE_DATA = createAction('Remove Data', props<Form>())

export const CLEAR_LIST = createAction('Clear List')