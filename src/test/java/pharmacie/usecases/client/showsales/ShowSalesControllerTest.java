package pharmacie.usecases.client.showsales;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pharmacie.TestSetup;

public class ShowSalesControllerTest {

  public ShowSalesInputBoundarySpy useCaseSpy;
  public ShowSalesOutputBoundarySpy presenterSpy;
  public ShowSalesViewSpy viewSpy;
  public ShowSalesController controller;

  @BeforeEach
  public void setUp()
  {
    TestSetup.setupSampleData();

    useCaseSpy = getCodecastSummariesInputBoundarySpy();
    presenterSpy = new ShowSalesOutputBoundarySpy();
    viewSpy = new ShowSalesViewSpy();
//    controller = new ShowSalesController(useCaseSpy, presenterSpy, viewSpy);
  }

  @Test
  public void testInputBoundaryInvocation() throws Exception
  {
    //TODO
//    ParsedRequest request = new ParsedRequest("GET", "blah");
//    controller.handle(request);
//
//    assertTrue(useCaseSpy.summarizeSalesWasCalled);
//    String loggedInUser = Context.userGateway.findUserByName("Bob").getId();
//    assertEquals(loggedInUser, useCaseSpy.requestedUser.getId());
//    assertSame(presenterSpy, useCaseSpy.outputBoundary);
  }

  @Test
  public void controllerSendsTheViewModelToTheView() throws Exception
  {
    //TODO
//    presenterSpy.viewModel = new CodecastSummariesViewModel();
//
//    ParsedRequest request = new ParsedRequest("GET", "blah");
//    controller.handle(request);
//
//    assertTrue(viewSpy.generateViewWasCalled);
//    assertSame(presenterSpy.viewModel, viewSpy.viewModel);
  }

  private ShowSalesInputBoundarySpy getCodecastSummariesInputBoundarySpy()
  {
    return new ShowSalesInputBoundarySpy();
  }

}
