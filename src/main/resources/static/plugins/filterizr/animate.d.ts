declare class Animator {
    private static process;

    static animate(node: HTMLElement, targetStyles: object): Promise<void>;
}

declare const _default: typeof Animator.animate;
export default _default;
