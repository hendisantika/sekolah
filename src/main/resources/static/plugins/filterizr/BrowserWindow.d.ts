/**
 * A wrapper class around the window object to manage the
 * resize event.
 *
 * When the user resizes the window, Filterizr needs to trigger
 * a refiltering of the grid so that the grid items can assume
 * their new positions.
 */
export default class BrowserWindow {
    private resizeHandler?;
    private debounceEventHandler;
    private removeResizeHandler;

    constructor();

    destroy(): void;

    setResizeEventHandler(resizeHandler: EventListener): void;
}
