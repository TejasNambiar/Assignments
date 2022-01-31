import { DebugElement } from '@angular/core';
import { async, ComponentFixture, fakeAsync, TestBed, tick, waitForAsync } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';
import { AsyncProductService } from '../async-product-service/async-product.service';

import { AsyncProductListComponent } from './async-product-list.component';

fdescribe('AsyncProductListComponent', () => {
  let component: AsyncProductListComponent;
  let fixture: ComponentFixture<AsyncProductListComponent>;
  let debugElement: DebugElement
  let productService: AsyncProductService

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AsyncProductListComponent ],
      imports: [FormsModule],
      providers: [AsyncProductService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AsyncProductListComponent);
    component = fixture.componentInstance;
    productService = TestBed.get(AsyncProductService)
    debugElement = fixture.debugElement
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should test filter Product List:: using done() callback', (done) => {
    component.searchText = 'fresh'
    let productspy = spyOn(productService, 'filterProductList').and.callThrough()

    component.filterProductList({})
    productspy.calls.mostRecent().returnValue.then(() =>{
      fixture.detectChanges()

      const VALUE =  debugElement.query(By.css("#product_0")).nativeElement.innerText;
      expect(VALUE).toContain(component.searchText);
      done()
    })
    
  });

  it('should test filter Product List:: using whenStable() (async)', waitForAsync(() => {
    component.searchText = 'fresh'
    let productspy = spyOn(productService, 'filterProductList').and.callThrough()

    component.filterProductList({})
    fixture.whenStable().then(() =>{
      fixture.detectChanges()

      const VALUE =  debugElement.query(By.css("#product_0")).nativeElement.innerText;
      expect(VALUE).toContain(component.searchText);
    })
    
  }));

  it('should test filter Product List:: using whenStable() (async)', fakeAsync(() => {
    component.searchText = 'fresh'
    let productspy = spyOn(productService, 'filterProductList').withArgs('fresh').and.callThrough()

    component.filterProductList({})

    /**
     * @tick - holds all other promises execution untill the promise
     * and all micro tasks of filterProductList execution is complete
     */
    tick();

      fixture.detectChanges()

      const VALUE =  debugElement.query(By.css("#product_0")).nativeElement.innerText;

    
  }));

  it('should test fakeasyn and tick concept', fakeAsync(() => {
    let isLogged = false
    setTimeout(() => {isLogged = true}, 100)
    expect(isLogged).toBeFalsy();
    tick(50) // 100ms not passed so still false
    expect(isLogged).toBeFalsy();
    tick(50) // 100ms passed so assigned true
    expect(isLogged).toBeTruthy();
  }));
});
