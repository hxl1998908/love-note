import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TabsetPortalComponent } from './tabset-portal.component';

describe('TabsetPortalComponent', () => {
  let component: TabsetPortalComponent;
  let fixture: ComponentFixture<TabsetPortalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabsetPortalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabsetPortalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
