import { TestBed } from '@angular/core/testing';
import { DummyData } from '../model/dummy-data';

import { LoginAuthenticationService } from './login-authentication.service';

describe('LoginAuthenticationService', () => {
  let service: LoginAuthenticationService;
  let Mock: DummyData[] = [
    {
      "firstName": "test 2",
      "lastName": "Last",
      "email": "test2@abc.com",
      "password": "test2"
    },
    {
        "firstName": "test 3",
        "lastName": "Last",
        "email": "test3@abc.com",
        "password": "test3"
    },
    {
        "firstName": "test4",
        "lastName": "Last",
        "email": "test4@abc.com",
        "password": "test4"
    }
  ]
  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginAuthenticationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should test the Validate method:: should fail', () =>{
    let userName = "lorem iptus"
    let password = "lorem iptus"
    let validMethod = service.validateUser(userName,password)

    // let store:any = {};

    // const mockLocalStorage = {
    //   getItem: (key: string): string => {
    //     return key in store ? JSON.parse(store[key]) : null;
    //   },
    //   setItem: (key: string, value: string) => {
    //     store[key] = `${value}`;
    //   }
    // };

    // spyOn(window.localStorage, 'setItem')
    //   .and.callFake(mockLocalStorage.setItem);

    let userWindow = localStorage.setItem('null',JSON.stringify({fname:null, lname:null, isLogged: false}))

    expect(validMethod).toBeFalsy()
    expect(userWindow).toEqual(service.User)
    localStorage.clear()
  })

  
  it('should test the Validate method:: should pass', () =>{
    let userName = "test2@abc.com"
    let password = "test2"
    service.user = Mock

    let userWindow = window.localStorage.setItem('currentUser',JSON.stringify({fname:"test 2", lname:"Last", isLogged: true}))

    let validMethod = service.validateUser(userName,password)
    expect(validMethod).toBeTruthy()
    expect(userWindow).toEqual(service.User)
  })

  it('should test the CurrentUser method:: returns object', () =>{

    let object = JSON.stringify({fname:"Sample 4", lname:"Last", isLogged: true})

    spyOn(localStorage,'getItem').withArgs('currentUser')
      .and.returnValue(object)

    let currentUserMethod = service.currentUser()

    expect(currentUserMethod).toEqual(JSON.parse(object))
    expect(currentUserMethod.isLogged).toBeTruthy()
  })

  it('should test the CurrentUser method:: returns object.isLogged false', () =>{

    spyOn(localStorage,'setItem').withArgs('null',JSON.stringify({fname:null, lname:null, isLogged: false}))
      .and.returnValue(JSON.parse(JSON.stringify({fname:null, lname:null, isLogged: false})))
    
    spyOn(localStorage,'getItem').withArgs('currentUser')
      .and.returnValue(JSON.stringify({}))

    // spyOn(localStorage,'getItem').withArgs('null')
    //   .and.returnValue(JSON.parse(JSON.stringify({fname:null, lname:null, isLogged: false})))

    let currentUserMethod = service.currentUser()
    
    expect(currentUserMethod.isLogged).toBeFalsy()
  })

  it('should test Window local Storage to be called', () =>{

    spyOn(window.localStorage,'clear')
    service.logUserOut()
    
    expect(window.localStorage.clear).toHaveBeenCalled()
  })
});