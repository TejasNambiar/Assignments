import { createAction, props } from "@ngrx/store";
import { Course } from "../entity/course";

export const ADD_COURSE = createAction('Add Course', props<Course>())
export const REMOVE_COURSE = createAction('Remove Course', props<Course>())
export const CLEAR_LIST = createAction('Clear List')